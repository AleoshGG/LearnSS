package aleosh.online.learnss.features.lessons.planets.domain.entities

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val PlanetParamsType = object : NavType<PlanetParams>(isNullableAllowed = false) {

    // 1. Cómo leerlo del Bundle (cuando llega a la pantalla destino)
    override fun get(bundle: Bundle, key: String): PlanetParams? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    // 2. Cómo convertir el String de la ruta de vuelta a Objeto
    override fun parseValue(value: String): PlanetParams {
        return Json.decodeFromString(Uri.decode(value))
    }

    // 3. Cómo convertir el Objeto a String para ponerlo en la URL
    override fun serializeAsValue(value: PlanetParams): String {
        return Uri.encode(Json.encodeToString(value))
    }

    // 4. Cómo guardarlo en el Bundle
    override fun put(bundle: Bundle, key: String, value: PlanetParams) {
        bundle.putString(key, Json.encodeToString(value))
    }
}