package org.sakaiproject.component.app.syllabus;


import java.util.Set;

import java.util.TreeSet;

import org.sakaiproject.api.app.syllabus.SyllabusTemplate;

/**
 * A syllabus template contains information relating to a syllabus template and an order
 * within a particular context (site).
 * 
 * @author Jon Demelo
 * @version $Id: 
 * 
 */

public class SyllabusTemplateImpl implements SyllabusTemplate
{
  private Long surrogateKey;
  private String userId;
  private String contextId;
  private String title;
  private String content;
  private Integer lockId; // optimistic lock
  
  private Set template = new TreeSet();
  
  /**
   *  Public no-arg Constructor.
   */
  public SyllabusTemplateImpl(){
    
    ;
  }
  
  
  /**
   * @param userId
   * @param contextId
   * @param title
   * @param content
   *        SyllabusEntry Constructor. Package protected.
   */
  public SyllabusTemplateImpl(String userId, String contextId, String title, String content)
  {

    if (userId == null || contextId == null)
    {
      throw new IllegalArgumentException();
    }
    
    this.userId = userId;    
    this.contextId = contextId;
    this.title = title;    
    this.content = content;
  }    

  
  /**
   * @return Returns the template.
   */
  public Set getTemplate()
  {
    return template;
  }
  /**
   * @param syllabi The syllabi template to set.
   */
  public void setTemplate(Set template)
  {
    this.template = template;
  }


  /**
   * @return Returns the template title.
   */
  public String getTemplateTitle()
  {
    return title;
  }
  /**
   * @param syllabi The syllabi template title to set.
   */
  public void setTemplateTitle(String title)
  {
    this.title = title;
  }


  /**
   * @return Returns the template content.
   */
  public String getTemplateContent()
  {
    return content;
  }
  /**
   * @param syllabi The syllabi template content to set.
   */
  public void setTemplateContent(String content)
  {
    this.content = content;
  }


  /**
   * @return Returns the contextId.
   */
  public String getContextId()
  {
    return contextId;
  }
  /**
   * @param contextId The contextId to set.
   */
  public void setContextId(String contextId)
  {
    this.contextId = contextId;
  }  
  /**
   * @return Returns the lockId.
   */
  public Integer getLockId()
  {
    return lockId;
  }
  /**
   * @param lockId The lockId to set.
   */
  public void setLockId(Integer lockId)
  {
    this.lockId = lockId;
  }
  /**
   * @return Returns the surrogateKey.
   */
  public Long getSurrogateKey()
  {
    return surrogateKey;
  }
  /**
   * @param surrogateKey The surrogateKey to set.
   */
  private void setSurrogateKey(Long surrogateKey)
  {
    this.surrogateKey = surrogateKey;
  }  
  /**
   * @return Returns the userId.
   */
  public String getUserId()
  {
    return userId;
  }
  /**
   * @param userId The userId to set.
   */
  public void setUserId(String userId)
  {
    this.userId = userId;
  }

  
  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (!(obj instanceof SyllabusTemplateImpl)) return false;
    SyllabusTemplateImpl other = (SyllabusTemplateImpl) obj;

    if ((userId == null ? other.userId == null : userId
        .equals(other.userId))        
        && (contextId == null ? other.contextId == null : contextId.equals(other.contextId))
        && (title == null ? other.title == null : title.equals(other.title)))
    {
      return true;
    }
    return false;
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  public int hashCode()
  {
    return userId.hashCode() + contextId.hashCode();
  }

  /**
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{surrogateKey=");
    sb.append(surrogateKey);
    sb.append(", userId=");
    sb.append(userId);    
    sb.append(", contextId=");
    sb.append(contextId);
    sb.append(", title=");
    sb.append(title);
    sb.append(", content=");
    sb.append(content);       
    sb.append(", lockId=");
    sb.append(lockId);
    sb.append("}");
    return sb.toString();
  }   
}