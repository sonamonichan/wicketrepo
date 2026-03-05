package com.arun.contacts;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import java.io.Serializable;


/**
 * Class that creates individual contact item in the contact list. This also has the link that can be accessed by overriding onClick() in ILinkListener of the constructor
 * Created by Arun on 3/2/2017.
 */
class ContactLink extends Panel {

    /**
     * Functional interface to replace the removed ILinkListener from Wicket 8+
     */
    @FunctionalInterface
    public interface LinkClickedCallback extends Serializable {
        void onLinkClicked();
    }

    /**
     *
     * @param id - component id
     * @param linkName - Name of the contact
     * @param linkClickedCallback - Callback to perform action when the contact is clicked
     */
     ContactLink(String id, String linkName,
                       LinkClickedCallback linkClickedCallback) {
        super(id);
        setRenderBodyOnly(true);
        add(generateLink(linkClickedCallback, linkName));
    }

    /**
     * Function creates th contact label and link
     * @param linkClickedCallback - contact onClick callback
     * @param linkName - contact lable name
     * @return
     */
    private Link<?> generateLink(final LinkClickedCallback linkClickedCallback,
                                 String linkName) {
        Label linkLabel = new Label("linkLabel", linkName);
        Link<String> link = new Link<String>("link") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                linkClickedCallback.onLinkClicked();
            }
        };
        link.add(linkLabel);
        return link;
    }


}
