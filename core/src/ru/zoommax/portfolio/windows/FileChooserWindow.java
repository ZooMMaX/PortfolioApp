package ru.zoommax.portfolio.windows;


import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.VisCheckBox;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.kotcrab.vis.ui.widget.VisWindow;
import com.kotcrab.vis.ui.widget.file.FileChooser;
import com.kotcrab.vis.ui.widget.file.FileTypeFilter;
import com.kotcrab.vis.ui.widget.file.StreamingFileChooserListener;

public class FileChooserWindow extends VisWindow {

    public FileChooserWindow () {
        super("filechooser");

        FileChooser.setDefaultPrefsName("com.kotcrab.vis.ui.test.manual");
        FileChooser.setSaveLastDirectory(true);
        final FileChooser chooser = new FileChooser(com.kotcrab.vis.ui.widget.file.FileChooser.Mode.OPEN);
        chooser.setSelectionMode(FileChooser.SelectionMode.FILES_AND_DIRECTORIES);
        chooser.setMultiSelectionEnabled(true);
        chooser.setFavoriteFolderButtonVisible(true);
        chooser.setShowSelectionCheckboxes(true);
//		chooser.setIconProvider(new ImgScalrFileChooserIconProvider(chooser));
        //chooser.setIconProvider(new HighResFileChooserIconProvider(chooser));
        chooser.setListener(new StreamingFileChooserListener() {
            @Override
            public void selected (FileHandle file) {
                System.out.println(file.path());
            }
        });
        final FileTypeFilter typeFilter = new FileTypeFilter(true);
        typeFilter.addRule("Image files (*.png, *.jpg, *.gif)", "png", "jpg", "gif");
        typeFilter.addRule("Text files (*.txt)", "txt");
        typeFilter.addRule("Audio files (*.mp3, *.wav, *.ogg)", "mp3", "wav", "ogg");

        VisTextButton open = new VisTextButton("mode open");
        VisTextButton save = new VisTextButton("mode save");
        final VisCheckBox useTypeFilter = new VisCheckBox("use type filter");
        final VisCheckBox multiSelect = new VisCheckBox("multi-selection");
        multiSelect.setChecked(true);

        TableUtils.setSpacingDefaults(this);

        open.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                chooser.setMode(FileChooser.Mode.OPEN);
                getStage().addActor(chooser.fadeIn());
            }
        });
        save.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                chooser.setMode(FileChooser.Mode.SAVE);
                getStage().addActor(chooser.fadeIn());
            }
        });
        useTypeFilter.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                if (useTypeFilter.isChecked()) {
                    chooser.setFileTypeFilter(typeFilter);
                } else {
                    chooser.setFileTypeFilter(null);
                }
            }
        });
        multiSelect.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                chooser.setMultiSelectionEnabled(multiSelect.isChecked());
            }
        });

        add(open);
        add(save).row();
        add(useTypeFilter).colspan(2).left().row();
        add(multiSelect).colspan(2).left().row();

        pack();
        //setPosition(950, 20);
    }
}
