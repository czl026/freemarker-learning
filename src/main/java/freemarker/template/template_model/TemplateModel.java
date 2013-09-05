/*
 * Copyright (c) 2003 The Visigoth Software Society. All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowledgement:
 *       "This product includes software developed by the
 *        Visigoth Software Society (http://www.visigoths.org/)."
 *    Alternately, this acknowledgement may appear in the software itself,
 *    if and wherever such third-party acknowledgements normally appear.
 *
 * 4. Neither the name "FreeMarker", "Visigoth", nor any of the names of the 
 *    project contributors may be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact visigoths@visigoths.org.
 *
 * 5. Products derived from this software may not be called "FreeMarker" or "Visigoth"
 *    nor may "FreeMarker" or "Visigoth" appear in their names
 *    without prior written permission of the Visigoth Software Society.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE VISIGOTH SOFTWARE SOCIETY OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Visigoth Software Society. For more
 * information on the Visigoth Software Society, please see
 * http://www.visigoths.org/
 */

package freemarker.template.template_model;

import freemarker.template.GeneralPurposeNothing;
import freemarker.template.utility.ClassUtil;

/**
 * The common super-interface of the interfaces that stand for the FreeMarker Template Language data types.
 * The template language only deals with {@link TemplateModel}-s, not with plain objects. This is why the data-model
 * (aka. the "template context" in other languages) is (automatically) mapped to a tree of {@link TemplateModel}-s.
 * 
 * <p>Mapping the plain Java objects to {@link TemplateModel}-s (or the other way around sometimes) is the
 * responsibility of the {@link freemarker.template.ObjectWrapper} (can be set via {@link freemarker.template.Configuration#setObjectWrapper(freemarker.template.ObjectWrapper)}).
 * But not all {@link TemplateModel}-s are for wrapping a plain object. For example, a value created within a template
 * is not made to wrap an earlier existing object; it's a value that has always existed in the template language's
 * domain. Users can also write {@link TemplateModel} implementations and put them directly into the data-model for
 * full control over how that object is seen from the template. Certain {@link TemplateModel} interfaces may doesn't
 * even have equivalent in Java. For example the directive type ({@link freemarker.template.TemplateDirectiveModel}) is like that.
 * 
 * <p>Because {@link TemplateModel} "subclasses" are all interfaces, a value in the template language can have multiple
 * types. However, to prevent ambiguous situations, it's not recommended to make values that implement more than one of
 * these types: string, number, boolean, date. The intended applications are like string+hash, string+method,
 * hash+sequence, etc.
 * 
 * @see ClassUtil#getFTLTypeDescription(TemplateModel)
 */
public interface TemplateModel {
    
    /**
     * A general-purpose object to represent nothing. It acts as
     * an empty string, false, empty sequence, empty hash, and
     * null-returning method model.
     */
    TemplateModel NOTHING = GeneralPurposeNothing.getInstance();
}