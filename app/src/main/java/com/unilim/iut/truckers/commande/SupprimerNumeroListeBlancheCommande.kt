package com.unilim.iut.truckers.commande

import android.content.Context
import android.util.Log
import com.unilim.iut.truckers.controleur.LogcatControleur
import com.unilim.iut.truckers.modele.JsonData

class SupprimerNumeroListeBlancheCommande(
    override var context: Context?,
    override var donnee: Any?
) : Commande() {

    private val logcatControleur = LogcatControleur()
    private val PAS_DE_MESSAGE_ENREGISTRE = -1

    override fun executer(): Boolean {
        val effectue = donnee?.let {
            jsonControleur.supprimerDonneesDansJSON(JsonData(context, "ListeBlanche.json", "liste_blanche", it, PAS_DE_MESSAGE_ENREGISTRE))
        }

        if (effectue == false) {
            Log.d("TruckerService", "Suppression d'un numéro dans la liste blanche impossible: $donnee")
            logcatControleur.ecrireDansFichierLog("Suppression d'un numéro dans la liste blanche impossible: $donnee")
            return false
        }

        Log.d("TruckerService", "Suppression d'un numéro dans la liste blanche: $donnee")
        logcatControleur.ecrireDansFichierLog("Suppression d'un numéro dans la liste blanche: $donnee")
        return true
    }
}