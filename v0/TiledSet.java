public class TiledSet {
    xmlLoader=new URLLoader();
    xmlLoader.addEventListener(Event.COMPLETE, xmlLoadComplete);
    xmlLoader.load(new URLRequest("../assets/example.tmx"));
}