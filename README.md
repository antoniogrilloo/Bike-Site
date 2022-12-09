# 2022_assignment3_GMP

Gruppo GMP:
* Antonio Grillo (851970)
* Giacomo Motta (851887)
* Gabriele Pandini (856598)

Link repository: https://gitlab.com/a.grillo22/2022_assignment3_gmp.git

## Descrizione progetto

Il progetto UniBike consiste in un interfaccia web per un amministratore di gare ciclistiche dell'ateneo. L'idea è quella di memorizzare le informazioni in una base di dati riguardo i percorsi effettuati e le sfide tra i partecipanti. Dunque, l'amministratore sarà in grado di apportare modifiche alla base di dati e visualizzare tutte le informazioni archiviate in essa.

Nel file "Schema_ER_base_di_dati.pdf" si trova lo schema ER del progetto.

Le possibili azioni dell'amministratore sono quelle di gestione dei percorsi e tutte quelle che riguardano i ciclisti, ovvero le relazioni di sfida, le biciclette possedute e la partecipazione a determinati percorsi.

Nello specifico vengono illustrate ora le possibili azioni di creazione:
* Aggiunta di un ciclista.
* Aggiunta di una bici.
* Aggiunta di un percorso da associare ad un dato ciclista.
* Memorizzazione delle sfide tra ciclisti.

Lettura:
* Dati sui ciclisti.
* Dati sulle sfide in corso tra i ciclisti.
* Dati relativi alle bici possedute da un ciclista. (*)
* Dati relativi ai percorsi di un ciclista.
* Dati relativi ai percorsi di più ciclisti.
* Dati relativi alle bici presenti.

Aggiornamento:
* Dati relativi alla disciplina primaria di un ciclista.
* Dati relativi ad un percorso di un ciclista.

Cancellazione:
* Bici associate ad un ciclista.
* Sfide tra ciclisti.
* Percorsi associati ad un ciclista.

Ricerca:
* Visualizzare i percorsi di un determinato ciclista.
* Visualizzare le sfide di un determinato ciclista.
* Dati relativi alle bici possedute da un ciclista. (*)
* Tutti i percorsi effettuati dai ciclisti in una determinata data.
