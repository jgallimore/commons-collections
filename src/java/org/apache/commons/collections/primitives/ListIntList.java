/*
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//collections/src/java/org/apache/commons/collections/primitives/Attic/ListIntList.java,v 1.2 2003/01/07 13:24:52 rwaldhoff Exp $
 * $Revision: 1.2 $
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

import java.util.List;

/**
 * Adapts a {@link Number}-valued {@link java.util.List List} 
 * to the {@link IntList} interface.
 *
 * @version $Revision: 1.2 $ $Date: 2003/01/07 13:24:52 $
 * @author Rodney Waldhoff 
 */
public class ListIntList extends CollectionIntCollection implements IntList {
    
    public ListIntList(List list) {
        super(list);        
        _list = list;
    }
    
    public void add(int index, int element) {
        _list.add(index,new Integer(element));
    }

    public boolean addAll(int index, IntCollection collection) {
        return _list.addAll(index,IntCollectionCollection.wrap(collection));
    }

    public int get(int index) {
        return ((Number)_list.get(index)).intValue();
    }

    public int indexOf(int element) {
        return _list.indexOf(new Integer(element));
    }

    public int lastIndexOf(int element) {
        return _list.lastIndexOf(new Integer(element));
    }

    public IntListIterator listIterator() {
        return ListIteratorIntListIterator.wrap(_list.listIterator());
    }

    public IntListIterator listIterator(int index) {
        return ListIteratorIntListIterator.wrap(_list.listIterator(index));
    }

    public int removeElementAt(int index) {
        return ((Number)_list.remove(index)).intValue();
    }

    public int set(int index, int element) {
        return ((Number)_list.set(index,new Integer(element))).intValue();
    }

    public IntList subList(int fromIndex, int toIndex) {
        return ListIntList.wrap(_list.subList(fromIndex,toIndex));
    }

    public boolean equals(Object that) {
        if(that instanceof IntList) {
            return _list.equals(IntListList.wrap((IntList)that));
        } else {
            return super.equals(that);
        }
    }
        
    public static IntList wrap(List list) {
        return null == list ? null : new ListIntList(list);
    }

    private List _list = null;

}
