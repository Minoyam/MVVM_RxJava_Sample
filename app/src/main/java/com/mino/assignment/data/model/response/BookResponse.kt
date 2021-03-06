package com.mino.assignment.data.model.response


import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("documents")
    val documents: List<DocumentResponse>,
    @SerializedName("meta")
    val meta: MetaResponse
) {
    fun documentsToModelList() = documents.map { documentResponse ->
        documentResponse.toModel()
    }

    fun metaToModel() = meta.toModel()

    fun isEmpty() = meta.totalCount == 0
}