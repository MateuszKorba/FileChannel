Katalog {user.home}/TPO1dir  zawiera pliki tekstowe umieszczone w tym katalogu i jego różnych podkatalogach. Kodowanie plików to Cp1250.
Przeglądając rekursywnie drzewo katalogowe, zaczynające się od {user.home}/TPO1dir,  wczytywać te pliki i dopisywać ich zawartości do pliku o nazwie TPO1res.txt, znadującym się w katalogu projektu. Kodowanie pliku TPO1res.txt winno być UTF-8, a po każdym uruchomieniu programu plik ten powinien zawierać tylko aktualnie przeczytane dane z  plików katalogu/podkatalogow.

Poniższy gotowy fragment winien wykonać całą robotę:
        
        public class Main {
                public static void main(String[] args) {
                        String dirName = System.getProperty("user.home")+"/TPO1dir";
                        String resultFileName = "TPO1res.txt";
                        Futil.processDir(dirName, resultFileName);
                }
        }
