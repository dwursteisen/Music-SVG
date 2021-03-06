/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sourceforge.musicsvg.module;

import abc.notation.Tune;
import abc.ui.swing.JScoreComponent;
import com.google.inject.Binder;
import com.google.inject.Module;
import javax.swing.JComponent;
import net.sourceforge.musicsvg.annotations.MainCanvas;
import net.sourceforge.musicsvg.render.NoteTranslater;
import net.sourceforge.musicsvg.render.Renderer;
import net.sourceforge.musicsvg.render.abc4j.Abc4jRendererImpl;
import net.sourceforge.musicsvg.render.abc4j.Abc4jTranslater;

/**
 *
 * @author Dav
 */
public class ABC4jModule implements Module{

    @Override
    public void configure(Binder binder) {
        Abc4jTranslater translater = new Abc4jTranslater();
        binder.bind(NoteTranslater.class).toInstance(translater);
        
        JScoreComponent jscore = new JScoreComponent();
        binder.bind(JScoreComponent.class).toInstance(jscore);
        binder.bind(JComponent.class).annotatedWith(MainCanvas.class).toInstance(jscore);
        binder.bind(Renderer.class).to(Abc4jRendererImpl.class);
    }

}
