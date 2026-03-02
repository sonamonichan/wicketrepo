package com.arun;

import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see com.arun.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        // add your configuration here

        // Configure Content-Security-Policy to allow loading of external stylesheets, fonts, and scripts
        getCspSettings().blocking()
            .add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.SELF)
            .add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.UNSAFE_INLINE)
            .add(CSPDirective.STYLE_SRC, "https://fonts.googleapis.com")
            .add(CSPDirective.STYLE_SRC, "https://maxcdn.bootstrapcdn.com")
            .add(CSPDirective.FONT_SRC, CSPDirectiveSrcValue.SELF)
            .add(CSPDirective.FONT_SRC, "https://fonts.gstatic.com")
            .add(CSPDirective.FONT_SRC, "data:")
            .add(CSPDirective.IMG_SRC, CSPDirectiveSrcValue.SELF)
            .add(CSPDirective.SCRIPT_SRC, CSPDirectiveSrcValue.SELF)
            .add(CSPDirective.SCRIPT_SRC, CSPDirectiveSrcValue.UNSAFE_INLINE);
    }
}
