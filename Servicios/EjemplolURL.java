import java.net.*;

public class EjemplolURL {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        URL url;
        try {
            System.out.println("Constructor simple para una URL:");
            url = new URL("http://store.steampowered.com/");
            Visualizar(url);

            System.out.println("Otro constructor simple para una URL:");
            url = new URL("https://www.reddit.com/");
            Visualizar(url);

            System.out.println("Const. para protocolo +URL +directorio:");
            url = new URL("https", "forocoches.com", "/foro/");
            Visualizar(url);

            System.out.println("Constructor para protocolo + URL + puerto + directorio:");
            url = new URL("https", "www.wikipedia.org", 443, "/wiki");
            Visualizar(url);

            System.out
                    .println("Constructor para un objeto URL y un directorio:");
            URL urlBase = new URL("https://www.bay12games.com");
            url = new URL(urlBase, "/dwarves/");
            Visualizar(url);

            System.out.println("Otro constructor simple para una URL:");
            url = new URL("http://localhost/PFC/gest/cli_gestion.php?S=3");
            Visualizar(url);

            System.out.println("Constructor para protocolo + URL + puerto +directorio:");
            url = new URL("https://fichajerapidocebem.web.app");
            Visualizar(url);

        } catch (MalformedURLException e) {
            System.out.println(e);
        }
    }// main

    private static void Visualizar(URL url) {
        System.out.println("\tURL completa: " + url.toString());
        System.out.println("\tgetProtocol(): " + url.getProtocol());
        System.out.println("\tgetHost (): " + url.getHost());
        System.out.println("\tgetPort(): " + url.getPort());
        System.out.println("\tgetFile() : " + url.getFile());
        System.out.println("\tgetUserInfo () : " + url.getUserInfo());
        System.out.println("\tgetPath () : " + url.getPath());
        System.out.println("\tgetAuthority(): " + url.getAuthority());
        System.out.println("\tgetQuery(): " + url.getQuery());
        System.out
                .println("==");
    }
}
// Ejemplo1URL