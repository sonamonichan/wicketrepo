package com.arun;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.csp.CSPDirective;

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

        // CSP configuration for Wicket 10
        getCspSettings().blocking().add(CSPDirective.STYLE_SRC, "'self'");
        getCspSettings().blocking().add(CSPDirective.STYLE_SRC, "https://fonts.googleapis.com");
        getCspSettings().blocking().add(CSPDirective.STYLE_SRC, "https://maxcdn.bootstrapcdn.com");
        getCspSettings().blocking().add(CSPDirective.FONT_SRC, "https://fonts.gstatic.com");
    }
}
