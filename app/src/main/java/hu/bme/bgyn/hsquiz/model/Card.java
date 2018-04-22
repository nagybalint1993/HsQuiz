package hu.bme.bgyn.hsquiz.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Card   {
  
  @SerializedName("cardId")
  private String cardId = null;
  
  @SerializedName("dbfId")
  private String dbfId = null;
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("cardSet")
  private String cardSet = null;
  
  @SerializedName("type")
  private String type = null;
  
  @SerializedName("faction")
  private String faction = null;
  
  @SerializedName("rarity")
  private String rarity = null;
  
  @SerializedName("cost")
  private Integer cost = null;
  
  @SerializedName("attack")
  private Integer attack = null;
  
  @SerializedName("health")
  private Integer health = null;
  
  @SerializedName("text")
  private String text = null;
  
  @SerializedName("flavor")
  private String flavor = null;
  
  @SerializedName("artist")
  private String artist = null;
  
  @SerializedName("collectible")
  private Boolean collectible = null;
  
  @SerializedName("elite")
  private Boolean elite = null;
  
  @SerializedName("playerClass")
  private String playerClass = null;
  
  @SerializedName("img")
  private String img = null;
  
  @SerializedName("imgGold")
  private String imgGold = null;
  
  @SerializedName("locale")
  private String locale = null;
  
  @SerializedName("mechanics")
  private String mechanics = null;
  

  
  /**
   * Id.
   **/
  @ApiModelProperty(value = "Id.")
  public String getCardId() {
    return cardId;
  }
  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  
  /**
   * DbfId
   **/
  @ApiModelProperty(value = "DbfId")
  public String getDbfId() {
    return dbfId;
  }
  public void setDbfId(String dbfId) {
    this.dbfId = dbfId;
  }

  
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
   * Cardset.
   **/
  @ApiModelProperty(value = "Cardset.")
  public String getCardSet() {
    return cardSet;
  }
  public void setCardSet(String cardSet) {
    this.cardSet = cardSet;
  }

  
  /**
   * Type of the card.
   **/
  @ApiModelProperty(value = "Type of the card.")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  
  /**
   * Faction
   **/
  @ApiModelProperty(value = "Faction")
  public String getFaction() {
    return faction;
  }
  public void setFaction(String faction) {
    this.faction = faction;
  }

  
  /**
   * Rarity.
   **/
  @ApiModelProperty(value = "Rarity.")
  public String getRarity() {
    return rarity;
  }
  public void setRarity(String rarity) {
    this.rarity = rarity;
  }

  
  /**
   * Cost of the card.
   **/
  @ApiModelProperty(value = "Cost of the card.")
  public Integer getCost() {
    return cost;
  }
  public void setCost(Integer cost) {
    this.cost = cost;
  }

  
  /**
   * Attack of the card.
   **/
  @ApiModelProperty(value = "Attack of the card.")
  public Integer getAttack() {
    return attack;
  }
  public void setAttack(Integer attack) {
    this.attack = attack;
  }

  
  /**
   * Cost of the card.
   **/
  @ApiModelProperty(value = "Cost of the card.")
  public Integer getHealth() {
    return health;
  }
  public void setHealth(Integer health) {
    this.health = health;
  }

  
  /**
   * The text of the card.
   **/
  @ApiModelProperty(value = "The text of the card.")
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  
  /**
   * Flavor
   **/
  @ApiModelProperty(value = "Flavor")
  public String getFlavor() {
    return flavor;
  }
  public void setFlavor(String flavor) {
    this.flavor = flavor;
  }

  
  /**
   * Artist
   **/
  @ApiModelProperty(value = "Artist")
  public String getArtist() {
    return artist;
  }
  public void setArtist(String artist) {
    this.artist = artist;
  }

  
  /**
   * .
   **/
  @ApiModelProperty(value = ".")
  public Boolean getCollectible() {
    return collectible;
  }
  public void setCollectible(Boolean collectible) {
    this.collectible = collectible;
  }

  
  /**
   * .
   **/
  @ApiModelProperty(value = ".")
  public Boolean getElite() {
    return elite;
  }
  public void setElite(Boolean elite) {
    this.elite = elite;
  }

  
  /**
   * Class of the card.
   **/
  @ApiModelProperty(value = "Class of the card.")
  public String getPlayerClass() {
    return playerClass;
  }
  public void setPlayerClass(String playerClass) {
    this.playerClass = playerClass;
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

  
  /**
   * Gold image gif url.
   **/
  @ApiModelProperty(value = "Gold image gif url.")
  public String getImgGold() {
    return imgGold;
  }
  public void setImgGold(String imgGold) {
    this.imgGold = imgGold;
  }

  
  /**
   * .
   **/
  @ApiModelProperty(value = ".")
  public String getLocale() {
    return locale;
  }
  public void setLocale(String locale) {
    this.locale = locale;
  }

  
  /**
   * .
   **/
  @ApiModelProperty(value = ".")
  public String getMechanics() {
    return mechanics;
  }
  public void setMechanics(String mechanics) {
    this.mechanics = mechanics;
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
    return Objects.equals(cardId, card.cardId) &&
        Objects.equals(dbfId, card.dbfId) &&
        Objects.equals(name, card.name) &&
        Objects.equals(cardSet, card.cardSet) &&
        Objects.equals(type, card.type) &&
        Objects.equals(faction, card.faction) &&
        Objects.equals(rarity, card.rarity) &&
        Objects.equals(cost, card.cost) &&
        Objects.equals(attack, card.attack) &&
        Objects.equals(health, card.health) &&
        Objects.equals(text, card.text) &&
        Objects.equals(flavor, card.flavor) &&
        Objects.equals(artist, card.artist) &&
        Objects.equals(collectible, card.collectible) &&
        Objects.equals(elite, card.elite) &&
        Objects.equals(playerClass, card.playerClass) &&
        Objects.equals(img, card.img) &&
        Objects.equals(imgGold, card.imgGold) &&
        Objects.equals(locale, card.locale) &&
        Objects.equals(mechanics, card.mechanics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardId, dbfId, name, cardSet, type, faction, rarity, cost, attack, health, text, flavor, artist, collectible, elite, playerClass, img, imgGold, locale, mechanics);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");
    
    sb.append("    cardId: ").append(toIndentedString(cardId)).append("\n");
    sb.append("    dbfId: ").append(toIndentedString(dbfId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cardSet: ").append(toIndentedString(cardSet)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    faction: ").append(toIndentedString(faction)).append("\n");
    sb.append("    rarity: ").append(toIndentedString(rarity)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    attack: ").append(toIndentedString(attack)).append("\n");
    sb.append("    health: ").append(toIndentedString(health)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    flavor: ").append(toIndentedString(flavor)).append("\n");
    sb.append("    artist: ").append(toIndentedString(artist)).append("\n");
    sb.append("    collectible: ").append(toIndentedString(collectible)).append("\n");
    sb.append("    elite: ").append(toIndentedString(elite)).append("\n");
    sb.append("    playerClass: ").append(toIndentedString(playerClass)).append("\n");
    sb.append("    img: ").append(toIndentedString(img)).append("\n");
    sb.append("    imgGold: ").append(toIndentedString(imgGold)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    mechanics: ").append(toIndentedString(mechanics)).append("\n");
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
