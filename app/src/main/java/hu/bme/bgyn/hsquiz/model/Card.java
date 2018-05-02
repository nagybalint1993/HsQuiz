package hu.bme.bgyn.hsquiz.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Card   {

  @SerializedName("name")
  private String name = null;

  @SerializedName("img")
  private String img = null;



  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  /**
   * image url.
   **/
  @ApiModelProperty(value = "image url.")
  public String getImg() {
    return img;
  }
  public void setImg(String img) {
    this.img = img;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(name, card.name) &&
            Objects.equals(img, card.img);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, img);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    img: ").append(toIndentedString(img)).append("\n");
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
