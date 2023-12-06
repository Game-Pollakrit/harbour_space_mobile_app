package com.harbourspace.unsplash.data.model

data class UnsplashItem(
    val alt_description: String,
    val blur_hash: String,
    val breadcrumbs: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: Any,
    val downloads: Int,
    val exif: Exif,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val location: Location,
    val meta: Meta,
    val promoted_at: String,
    val public_domain: Boolean,
    val slug: String,
    val sponsorship: Any,
    val tags: List<Tag>,
    val tags_preview: List<TagsPreview>,
    val topics: List<Any>,
    val updated_at: String,
    val urls: Urls,
    val user: User,
    val views: Int,
    val width: Int
)