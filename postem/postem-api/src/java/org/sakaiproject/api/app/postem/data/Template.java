/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/postem/branches/sakai-2.9.x/postem-api/src/java/org/sakaiproject/api/app/postem/data/Template.java $
 * $Id: Template.java 59680 2009-04-03 23:28:39Z arwhyte@umich.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2003, 2004, 2005, 2006, 2008 The Sakai Foundation
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

package org.sakaiproject.api.app.postem.data;

public interface Template {
	public String getTemplateCode();

	public void setTemplateCode(String templateCode);

	public String fillGrades(StudentGrades student);
}
