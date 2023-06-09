package gr.aueb.cf.ch10;
/*
* Γράψτε δύο μεθόδους που αφορούν την αντιγραφή δυσδιάστατων πινάκων. Μία
μέθοδο int[][] shallowCopy(int[][] arr) που αντιγράφει ένα δυσδιάστατο πίνακα αλλά
μόνο τις τιμές του βασικού πίνακα που είναι αναφορές στους πίνακες που είναι
στοιχεία του βασικού πίνακα. Και μία μέθοδο int[][] deepCopy(int[][] arr).
Γράψτε μία main που να δείχνετε γιατί το shallow copy δεν δουλεύει όπως θα θέλαμε,
αφού αλλάζοντας ένα στοιχείο ενός πίνακα από δύο για παράδειγμα copies, αλλάζει
το στοιχείο και στον άλλο πίνακα, αφού κατά βάση πρόκειται για ένα και μόνο κοινό
στοιχείο (αφού έχει γίνει shallow copy).
Δείξτε και την περίπτωση του deep copy. Δείξτε ότι δουλεύει όπως θα θέλαμε.
Δηλαδή δεν επηρεάζουν οι αλλαγές στοιχείων το κάθε copy, το οποίο τώρα είναι
ανεξάρτητο.
7
Hint. Ένας δυσδιάστατος πίνακας είναι ένας βασικός πίνακας που έχει ως στοιχεία
πίνακες. Η shallowCopy() αντιγράφει ένα δυσδιάστατο πίνακα χρησιμοποιώντας
κάποια μέθοδο όπως Arrays.copyOf() ή System.arraycopy(). Όμως αυτές οι μέθοδοι
κάνουν shallow copies δηλαδή αντιγράφουν τις αναφορές των υποπινάκων του
βασικού πίνακα. Αν δηλαδή θεωρήσουμε ότι ένας δυσδιάστατος πίνακας
αποτελείται από μία κάθετη στήλη που είναι ο βασικός πίνακας και οριζόντιες
γραμμές που αντιστοιχούν στους πίνακες που είναι στοιχεία ου βασικού πίνακα
(οπότε τελικά έχουμε ένα δυσδιάστατο πίνακα), τότε το shallow copy αντιγράφει
μόνο τα στοιχεία του βασικού πίνακα που είναι όμως οι αναφορές προς τους
οριζόντιους πίνακες. Αυτό σημαίνει πως ο πίνακας που έχει αντιγραφεί δεν είναι
ανεξάρτητο copy αλλά αν αλλάξει κάτι στα στοιχεία του αντιγραμμένου πίνακα,
αλλάζουν ταυτόχρονα και τα στοιχεία του αρχικού πίνακα, αφού μόνο οι αναφορές
έχουν αντιγραφεί και όχι και τα στοιχεία των πινάκων στην οριζόντια διάσταση. Αφού
οι πίνακες είναι mutable (και όχι immutable όπως τα Strings) οι αλλαγές που γίνονται
στο ένα copy αφορούν έμμεσα και το άλλο copy, κάτι το οποίο δεν είναι σωστό για
mutable στοιχεία πινάκων (όπως πίνακες και κλάσεις ή οποιοδήποτε άλλο mutable
στοιχείο).
* */
public class MiniProject07 {
    public static void main(String[] args) {

    }
}
