/*
* Copyright 2011 JBoss Inc
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.drools.guvnor.client.widgets.tables;

import org.drools.guvnor.client.messages.ConstantsCore;
import org.drools.guvnor.client.resources.ImagesCore;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * A Cell to display the 'state' of an Asset, i.e. whether it is enabled or disabled
 */
public class RuleEnabledStateCell extends AbstractCell<Boolean> {

    protected static final ConstantsCore constants = GWT.create( ConstantsCore.class );

    protected static final ImagesCore images    = (ImagesCore) GWT.create( ImagesCore.class );

    private SafeHtml                 shtml;

    public RuleEnabledStateCell() {
        //Do the expensive operations in the constructor 
        AbstractImagePrototype aip = AbstractImagePrototype.create( images.warning() );
        SafeHtml icon = SafeHtmlUtils.fromTrustedString( aip.getHTML() );
        shtml = SafeHtmlUtils.fromTrustedString( "<div title='" + constants.AssetTableIsDisabledTip() + "'>" + icon.asString() + "</div>" );
    }

    @Override
    public void render(Context context,
                       Boolean value,
                       SafeHtmlBuilder sb) {
        if (value) {
            sb.append( shtml );
        }
    }

}
