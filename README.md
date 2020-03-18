# CreateLabyrinth

## Cosa fa?
In base alle immagini che salvo nella cartella "Images", creo dei nuovi files,situati nella cartella Files.Ogni file contiene tutti i valori dell'array del labirinto. A questo punto basta incollare il contenuto del file sostituend int DIMENSIONE e mkStruct(). 

## Come devono essere le immagini?
Principalmente in formato .png e quadrate, con soltanto due colori, bianco e nero. Il bianco indica le pareti, quando vi è un pixel bianco nella posizione x,y l'array[y][x] assumerà il valore false, proprio perchè non è possibile raggiungere quel punto.

## Come avviarlo?
Semplicemente bisogna inserire le immagini all'interno della cartella Images. Fatto ciò,aprire il programma come un normale progetto ed eseguire il main.I files di testo verranno salvati nella cartella Files.
