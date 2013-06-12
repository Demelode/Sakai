/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/syllabus/branches/sakai-2.9.x/syllabus-impl/src/java/org/sakaiproject/component/app/syllabus/SyllabusManagerImpl.java $
 * $Id: SyllabusManagerImpl.java 92712 2011-05-09 18:11:49Z gjthomas@iupui.edu $
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
package org.sakaiproject.api.app.syllabus;

import java.util.Set;

public interface SyllabusTemplateManager
{
  public SyllabusTemplate createSyllabusTemplate(String userId, String contextId, String title, String content);

  public void saveSyllabusTemplate(SyllabusTemplate syllabusTemplate);

  public void removeSyllabusTemplate(SyllabusTemplate syllabusTemplate);

  public SyllabusTemplate getSyllabusTemplateByContextId(final String contextId);

  public SyllabusTemplate getSyllabusTemplateByUserAndContextIds(final String userId, final String contextId);
  
  public Integer findLargestSyllabusTemplatePosition(final SyllabusTemplate syllabusTemplate);  
}