/**********************************************************************************
* $URL: https://source.sakaiproject.org/svn/warehouse/branches/sakai-2.9.x/warehouse-impl/impl/src/java/org/sakaiproject/warehouse/impl/SelfPropertyAccess.java $
* $Id: SelfPropertyAccess.java 59691 2009-04-03 23:46:45Z arwhyte@umich.edu $
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

import org.sakaiproject.warehouse.service.PropertyAccess;

/**
 * Created by IntelliJ IDEA.
 * User: John Ellis
 * Date: Nov 30, 2005
 * Time: 5:48:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelfPropertyAccess implements PropertyAccess {
   public Object getPropertyValue(Object source) throws Exception {
      return source;
   }
}
