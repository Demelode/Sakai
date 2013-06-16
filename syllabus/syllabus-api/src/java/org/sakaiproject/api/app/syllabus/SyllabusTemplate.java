/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/syllabus/branches/sakai-2.9.x/syllabus-api/src/java/org/sakaiproject/api/app/syllabus/SyllabusData.java $
 * $Id: SyllabusData.java 77661 2010-05-21 15:27:32Z gjthomas@iupui.edu $
 ***********************************************************************************
 *
 * Copyright (c) 2003, 2004, 2005, 2006, 2008, 2009, 2010, 2011, 2012, 2013 The Sakai Foundation
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

/**
 * @author <a href="mailto:demelode@gmail.com">Jon Demelo</a>
 * @version $id
 */
public interface SyllabusTemplate
{

  /**
   * @return Returns the Template content.
   */
  public String getTemplateContent();

  /**
   * @param content The Template content to set.
   */
  public void setTemplateContent(String content);

  /*
   * @return Returns the Template title.
   */
  public String getTemplateTitle();

  /**
   * @param title The Template title to set.
   */
  public void setTemplateTitle(String title);

  /**
   * @return Returns the posId.
   */
  public Integer getPosId();

  /**
   * @param posId The posId to set.
   */
  public void setPosId(Integer posId);

  /**
   * @return Returns the lockId.
   */
  public Integer getLockId();

  /**
   * @param lockId The lockId to set.
   */
  public void setLockId(Integer lockId);

  /**
   * @return Returns the surrogateKey.
   */
  public Long getSurrogateKey();
  
  /**
   * @param surrogateKey The surrogateKey to set.
   */
  public void setSurrogateKey(Long surrogateKey);
}