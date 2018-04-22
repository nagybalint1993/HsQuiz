package hu.bme.bgyn.hsquiz.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Result   {
  
  @SerializedName("User")
  private String user = null;
  
  @SerializedName("Point")
  private Integer point = null;
  
  @SerializedName("objectId")
  private String objectId = null;
  
  @SerializedName("___class")
  private String _class = null;
  

  
  /**
   * Username
   **/
  @ApiModelProperty(value = "Username")
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }

  
  /**
   * Scored points
   **/
  @ApiModelProperty(value = "Scored points")
  public Integer getPoint() {
    return point;
  }
  public void setPoint(Integer point) {
    this.point = point;
  }

  
  /**
   * ID
   **/
  @ApiModelProperty(value = "ID")
  public String getObjectId() {
    return objectId;
  }
  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  
  /**
   * The name of the table in the database.
   **/
  @ApiModelProperty(value = "The name of the table in the database.")
  public String getClassAttribute() {
    return _class;
  }
  public void setClass(String _class) {
    this._class = _class;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    Result result = (Result) o;
    return Objects.equals(user, result.user) &&
        Objects.equals(point, result.point) &&
        Objects.equals(objectId, result.objectId) &&
        Objects.equals(_class, result._class);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, point, objectId, _class);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Result {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    point: ").append(toIndentedString(point)).append("\n");
    sb.append("    objectId: ").append(toIndentedString(objectId)).append("\n");
    sb.append("    _class: ").append(toIndentedString(_class)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
