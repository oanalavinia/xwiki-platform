/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.notifications.filters.internal;

import java.util.Arrays;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.model.reference.LocalDocumentReference;
import org.xwiki.text.StringUtils;

import com.xpn.xwiki.doc.AbstractMandatoryClassInitializer;
import com.xpn.xwiki.objects.classes.BaseClass;

/**
 * Define the NotificationFilterPreferenceClass XClass.
 * This XClass is used to store filters information in the user profile.
 *
 * @version $Id$
 * @since 9.7RC1
 */
@Component
@Named("XWiki.Notifications.Code.NotificationFilterPreferenceClass")
@Singleton
public class NotificationFilterPreferenceDocumentInitializer extends AbstractMandatoryClassInitializer
{
    /**
     * The path to the class parent document.
     */
    private static final List<String> PARENT_PATH = Arrays.asList("XWiki", "Notifications", "Code");

    private static final String INPUT = "input";

    private static final String SELECT = "select";

    private static final String SEPARATORS = "|, ";

    /**
     * Default constructor.
     */
    public NotificationFilterPreferenceDocumentInitializer()
    {
        super(new LocalDocumentReference(PARENT_PATH, "NotificationFilterPreferenceClass"));
    }

    @Override
    protected void createClass(BaseClass xclass)
    {
        xclass.addTextField("filterPreferenceName", "Name of the filter preference", 256);
        xclass.addTextField("filterName", "Filter name", 64);
        xclass.addStaticListField("filterType", "Filter type", 64, false,
                "inclusive=Inclusive|exclusive=Exclusive", SELECT, SEPARATORS);
        xclass.addStaticListField("filterFormats", "Formats", 64, true,
                "alert=Alert|email=E-mail", SELECT, SEPARATORS);

        xclass.addStaticListField("applications", "Applications", 64, true,
                false, StringUtils.EMPTY, INPUT, SEPARATORS);
        xclass.addStaticListField("eventTypes", "Event types", 64, true,
                false, StringUtils.EMPTY, INPUT, SEPARATORS);
        xclass.addUsersField("users", "Users", true);
        xclass.addStaticListField("pages", "Pages", 64, true,
                false, StringUtils.EMPTY, INPUT, SEPARATORS);
        xclass.addStaticListField("spaces", "Spaces", 64, true,
                false, StringUtils.EMPTY, INPUT, SEPARATORS);
        xclass.addStaticListField("wikis", "Wikis", 64, true,
                false, StringUtils.EMPTY, INPUT, SEPARATORS);
    }
}