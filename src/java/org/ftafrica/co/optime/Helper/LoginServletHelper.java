/*LoginServlet Class is a helper class that helps in generate a  json String from a java object, this object helps in 
getting the url for the post and get method and the status of the transaction, 
 
 */

package org.ftafrica.co.optime.Helper;

/**
 *
 * @author Training 8
 */
public class LoginServletHelper {
    
   private String status;
    private String url;
  private String sessionTrackerID;

    public LoginServletHelper(String status, String url, String sessionTrackerID) {
        this.status = status;
        this.url = url;
        this.sessionTrackerID = sessionTrackerID;
    }

    public LoginServletHelper() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSessionTrackerID() {
        return sessionTrackerID;
    }

    public void setSessionTrackerID(String sessionTrackerID) {
        this.sessionTrackerID = sessionTrackerID;
    }
    
    
    
}
