package shop.mtcoding.web1.config;

public class ViewResolver {
    private static String prefix = "/WEB-INF";
    private static String suffix = ".jsp";

    public static String resolve(String viewName){
        return prefix+viewName+suffix;
    }
}
