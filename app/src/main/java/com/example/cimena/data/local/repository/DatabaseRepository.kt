interface DatabaseRepository {
    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit)
}