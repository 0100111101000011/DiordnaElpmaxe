package volleyjson.hfad.com.maintenanceissue;

/**
 * Created by Test on 2017-11-06.
 */

public class Supplier
{

        private String title;
        private int image;


    public Supplier(String title,int imageUrl){

            this.title = title;
            this.image = imageUrl;
        }

        public String getTitle() {
            return title;
        }

        public int getImage() {
            return image;
        }
}
