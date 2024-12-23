## Link e contatti
* mail: galli.rcrd[at]gmail.com, riccardo.inverardigalli[at]yahoo.com
* github: https://github.com/ricvigi
* repository del progetto: https://github.com/ricvigi/turing-phonebook

## Istruzioni
Per runnare il file, navigare nella cartella dove è contenuto il file jar ed eseguire il seguente comando
``` bash
java -cp PhoneBook-1.0-SNAPSHOT.jar com.mycompany.phonebook.phoneBookGUI
```
Il programma presenta le funzionalità richieste nelle linee guida "Progetto_Rubrica". La finestra principale possiete tre bottoni, "New", "Modify", e "Delete". Per ognuno di questi bottoni è stata implementata la funzionalità richiesta. Quando si inserisce o si modifica un contatto, appare una finestra dedicata. 
I dati dei contatti vengono salvati in un file "info.txt", che viene creato al momento del primo lancio dell'applicazione se non è già presente. Il file è formattato con i campi richiesti nelle linee guida, con l'aggiunta di un campo iniziale "id", una stringa casuale necessaria per garantire l'unicità di ogni contatto
