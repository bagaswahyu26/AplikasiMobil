package id.ac.amikom.appmobil.data.model

data class ActionState<T>(
    val data: T? = null,
    val message: String?= null,
    val issSuccess: Boolean = true,
    var isConsumed : Boolean = false
)