/*
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//collections/src/java/org/apache/commons/collections/primitives/Attic/IntListList.java,v 1.3 2003/01/07 13:24:52 rwaldhoff Exp $
 * $Revision: 1.3 $
 * $Date: 2003/01/07 13:24:52 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights
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
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
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
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.commons.collections.primitives;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * Adapts an {@link IntList} to the
 * {@link java.util.List List} interface.
 *
 * @version $Revision: 1.3 $ $Date: 2003/01/07 13:24:52 $
 * @author Rodney Waldhoff 
 */
public class IntListList extends IntCollectionCollection implements List {
    
    public IntListList(IntList list) {
        super(list);        
        _list = list;
    }
    
    public void add(int index, Object element) {
        _list.add(index,((Number)element).intValue());
    }

    public boolean addAll(int index, Collection c) {
        return _list.addAll(index,CollectionIntCollection.wrap(c));
    }

    public Object get(int index) {
        return new Integer(_list.get(index));
    }

    public int indexOf(Object element) {
        return _list.indexOf(((Number)element).intValue());
    }

    public int lastIndexOf(Object element) {
        return _list.lastIndexOf(((Number)element).intValue());
    }

    public ListIterator listIterator() {
        return IntListIteratorListIterator.wrap(_list.listIterator());
    }

    public ListIterator listIterator(int index) {
        return IntListIteratorListIterator.wrap(_list.listIterator(index));
    }

    public Object remove(int index) {
        return new Integer(_list.removeElementAt(index));
    }

    public Object set(int index, Object element) {
        return new Integer(_list.set(index, ((Number)element).intValue() ));
    }

    public List subList(int fromIndex, int toIndex) {
        return IntListList.wrap(_list.subList(fromIndex,toIndex));
    }

    public boolean equals(Object that) {
        if(that instanceof List) {
            try {
                return _list.equals(ListIntList.wrap((List)that));
            } catch(NullPointerException e) {
                return false;
            } catch(ClassCastException e) {
                return false;
            }
        } else {
            return super.equals(that);
        }
    }
    
    public static List wrap(IntList list) {
        return null == list ? null : new IntListList(list);
    }

    private IntList _list = null;

}
