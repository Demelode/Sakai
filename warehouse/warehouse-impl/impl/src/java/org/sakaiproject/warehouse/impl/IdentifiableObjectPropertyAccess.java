/**********************************************************************************
* $URL: https://source.sakaiproject.org/svn/warehouse/branches/sakai-2.9.x/warehouse-impl/impl/src/java/org/sakaiproject/warehouse/impl/IdentifiableObjectPropertyAccess.java $
* $Id: IdentifiableObjectPropertyAccess.java 59691 2009-04-03 23:46:45Z arwhyte@umich.edu $
***********************************************************************************
*
 * Copyright (c) 2005, 2006, 2007, 2008 The Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*
**********************************************************************************/
package org.sakaiproject.warehouse.impl;

import org.sakaiproject.metaobj.shared.model.IdentifiableObject;

/**
 * Created by IntelliJ IDEA.
 * User: John Ellis
 * Date: Dec 18, 2005
 * Time: 9:33:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class IdentifiableObjectPropertyAccess extends BeanPropertyAccess {

   public Object getPropertyValue(Object source) throws Exception {
      Object obj = super.getPropertyValue(source);
      IdentifiableObject object = null;
      try {
         object = (IdentifiableObject)obj;
      } catch(ClassCastException cce) {
         throw new Exception("Class " + obj.getClass().getName() + 
               " is not derived from IdentifiableObject", cce);
      }
      if (object != null) {
         if(object.getId() != null)
            return object.getId().getValue();
      }
      return null;
   }
}
