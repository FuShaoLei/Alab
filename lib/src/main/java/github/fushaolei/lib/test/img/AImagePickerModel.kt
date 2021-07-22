package github.fushaolei.lib.test.img

import android.content.Context
import android.provider.MediaStore
import github.fushaolei.lib.test.entitiy.AlabImage
import kotlin.concurrent.thread

object AImagePickerModel {
    fun loadImage(context: Context, callback: DataCallback) {
        thread {
            var mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            var mContentResolver = context.contentResolver
            var mCursor = mContentResolver.query(mImageUri, arrayOf(
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DATE_ADDED,
                MediaStore.Images.Media._ID
            ),
                null,
                null,
                MediaStore.Images.Media.DATE_ADDED)

            var images = ArrayList<AlabImage>()

            while (mCursor?.moveToNext() == true) {

                val id = mCursor.getLong(mCursor.getColumnIndex(MediaStore.Images.Media._ID))
                var path = mCursor.getString(
                    mCursor.getColumnIndex(MediaStore.Images.Media.DATA))
                var name = mCursor.getString(
                    mCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                var time = mCursor.getLong(
                    mCursor.getColumnIndex(MediaStore.Images.Media.DATE_ADDED));
                val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon()
                    .appendPath(id.toString()).build()
                images.add(AlabImage(path, time, name, uri))

            }
            mCursor?.close()

            images.reverse()
            callback.onSuccess(images)
        }
    }

    interface DataCallback {
        fun onSuccess(alabImages: ArrayList<AlabImage>)
    }
}