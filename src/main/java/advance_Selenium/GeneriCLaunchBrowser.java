package advance_Selenium;

public class GeneriCLaunchBrowser {

    enum BROWSER{
        CHROME,FIREFOX,SAFARI,IE,EDGE;
    }


    public void launchBrowser(BROWSER browser){
        switch (browser){
            case CHROME:
                System.out.println("Launch CHROME");
                break;
            case FIREFOX:
                System.out.println("Launch FIREFOX");
                break;
            case EDGE:
                break;
            case SAFARI:
                break;
            case IE:
                break;
            default:
                System.out.println("do nothing");
                break;
        }
    }


    public static void main(String[] args) {
        GeneriCLaunchBrowser l = new GeneriCLaunchBrowser();
        l.launchBrowser(BROWSER.CHROME);
    }


}


