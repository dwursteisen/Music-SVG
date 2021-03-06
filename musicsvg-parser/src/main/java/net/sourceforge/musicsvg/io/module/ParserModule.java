/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sourceforge.musicsvg.io.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import net.sourceforge.musicsvg.io.gp.GP4Parser;
import net.sourceforge.musicsvg.io.gp.listeners.GP4ParserListener;
import net.sourceforge.musicsvg.io.JFugueParser;
import net.sourceforge.musicsvg.io.gp.listeners.GP4InfoParserListenerImpl;

/**
 *
 * @author david
 */
public class ParserModule implements Module {

    @Override
    public void configure(Binder binder) {
        // PARSER
        binder.bind(GP4ParserListener.class).to(GP4InfoParserListenerImpl.class);

        GP4Parser gp4Parser = new GP4Parser();
        binder.bind(GP4Parser.class).toInstance(gp4Parser);
        
        JFugueParser jfugueParser = new JFugueParser();
        binder.bind(JFugueParser.class).toInstance(jfugueParser);
    }
}
