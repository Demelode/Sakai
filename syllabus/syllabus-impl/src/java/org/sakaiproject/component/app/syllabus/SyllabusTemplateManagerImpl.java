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
package org.sakaiproject.component.app.syllabus;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import org.sakaiproject.api.app.syllabus.SyllabusTemplateManager;
import org.sakaiproject.api.app.syllabus.SyllabusTemplate;

import org.sakaiproject.component.cover.ServerConfigurationService;
import org.sakaiproject.content.api.ContentHostingService;
import org.sakaiproject.content.api.ContentResource;
import org.sakaiproject.user.cover.UserDirectoryService;
import org.sakaiproject.user.api.User;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * SyllabusTemplateManagerImpl provides convenience functions to query the database
 * @author <a href="mailto:demelode@gmail.com">Jon Demelo </a>
 * @version $Id:
 */
public class SyllabusTemplateManagerImpl extends HibernateDaoSupport implements SyllabusTemplateManager
{
  private ContentHostingService contentHostingService;

  private static final String QUERY_TEMPLATE_BY_USERID_AND_CONTEXTID = "findSyllabusTemplateByUserAndContextIds";
  private static final String QUERY_TEMPLATE_BY_CONTEXTID = "findSyllabusTemplateByContextId";
  private static final String QUERY_LARGEST_TEMPLATE_POSITION = "findLargestSyllabusTemplatePosition";
  private static final String USER_ID = "userId";
  private static final String CONTEXT_ID = "contextId";
  private static final String SURROGATE_KEY = "surrogateKey";
  private static final String VIEW = "view";
  private static final String SYLLABI = "syllabi";  
  private static final String FOREIGN_KEY = "foreignKey";
  

  public void setContentHostingService(ContentHostingService contentHostingService) {
        this.contentHostingService = contentHostingService;
    }
  

  /**
   * createSyllabusTemplate creates a new SyllabusTemplate
   * @param userId
   * @param contextId
   * @param title
   * @param content
   * @return syllabusTemplate  
   */
  public SyllabusTemplate createSyllabusTemplate(String userId, String contextId,
      String title, String content)
  {
    if (userId == null || contextId == null || title == null)
    {
      throw new IllegalArgumentException("Null Argument");
    }
    else
    {
      // construct a new SyllabusTemplate
      SyllabusTemplate syllabusTemplate = new SyllabusTemplateImpl(userId, contextId, title, content);      
      saveSyllabusTemplate(syllabusTemplate);
      return syllabusTemplate;
    }
  }


  /**
   * saveSyllabusTemplate persists a SyllabusTemplate
   * @param syllabusTemplate
   */
  public void saveSyllabusTemplate(SyllabusTemplate syllabusTemplate)
  {
    getHibernateTemplate().saveOrUpdate(syllabusTemplate);
  }
  

  /**
   * getSyllabusTemplateByContextId finds a SyllabusTemplate
   * @param contextId
   * @return SyllabusTemplate    
   */
  public SyllabusTemplate getSyllabusTemplateByContextId(final String contextId)
  {
    if (contextId == null)
    {
      throw new IllegalArgumentException("Null Argument");
    }
          
    HibernateCallback hcb = new HibernateCallback()
    {
      public Object doInHibernate(Session session) throws HibernateException,
          SQLException
      {
        Query q = session.getNamedQuery(QUERY_TEMPLATE_BY_CONTEXTID);                        
        q.setParameter(CONTEXT_ID, contextId, Hibernate.STRING);                   
        return q.uniqueResult();
      }
    };
        
    return (SyllabusTemplate) getHibernateTemplate().execute(hcb);
  }


  /**
   * getSyllabusTemplateByUserAndContextIds finds a SyllabusTemplate
   * @param userId
   * @param contextId
   * @return SyllabusTemplate     
   */
  public SyllabusTemplate getSyllabusTemplateByUserAndContextIds(final String userId, final String contextId)
  {
    if (userId == null || contextId == null)
    {
      throw new IllegalArgumentException("Null Argument");
    }
          
    HibernateCallback hcb = new HibernateCallback()
    {
      public Object doInHibernate(Session session) throws HibernateException,
          SQLException
      {
        Query q = session.getNamedQuery(QUERY_TEMPLATE_BY_USERID_AND_CONTEXTID);                
        q.setParameter(USER_ID, userId, Hibernate.STRING);
        q.setParameter(CONTEXT_ID, contextId, Hibernate.STRING);                   
        return q.uniqueResult();
      }
    };
        
    return (SyllabusTemplate) getHibernateTemplate().execute(hcb);
  }


  /**
   * findLargestSyllabusTemplatePosition finds the largest syllabus template position for an item
   * @param syllabusTemplate
   */
  public Integer findLargestSyllabusTemplatePosition(final SyllabusTemplate syllabusTemplate)      
  {
    if (syllabusTemplate == null)
    {
      throw new IllegalArgumentException("Null Argument");
    }
    else
    {
      HibernateCallback hcb = new HibernateCallback()
      {                
        public Object doInHibernate(Session session) throws HibernateException,
            SQLException
        {            
          Query q = session.getNamedQuery(QUERY_LARGEST_TEMPLATE_POSITION);                
          q.setParameter(FOREIGN_KEY, syllabusTemplate.getSurrogateKey(), Hibernate.LONG);
          
          Integer position = (Integer) q.uniqueResult();
          
          if (position == null){
            return new Integer(0);
          }
          else{
            return position;
          }
          
        }
      };
      return (Integer) getHibernateTemplate().execute(hcb);
    }
  }    

  public void removeSyllabusTemplate(SyllabusTemplate syllabusTemplate)
  {
    getHibernateTemplate().delete(syllabusTemplate);
  }

}