package com.example.imoteb

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.fragment.app.FragmentActivity
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class IntentShare
{
    companion object
    {


        fun sharePhoto(context: Context, bitmap: Bitmap, activity: FragmentActivity): Intent
        {
            SaveImageOnCatch(context, bitmap)
            return  SharePhotoIntent(context, bitmap, activity)
            val resultIntent= SharePhotoIntent(context, bitmap, activity)
            Intent.createChooser(resultIntent, "Choose an app")
            return resultIntent
        }

        fun sharePhotoWithText(context: Context,
            bitmap: Bitmap,
            activity: FragmentActivity,
            text: String): Intent
        {
            SaveImageOnCatch(context, bitmap)
            val resultIntent= SharePhotoIntent(context, bitmap, activity)
            resultIntent.putExtra(Intent.EXTRA_TEXT,text)
            Intent.createChooser(resultIntent, "Choose an app")
            return  resultIntent
        }

        private fun SharePhotoIntent(context: Context,
            bitmap: Bitmap,
            activity: FragmentActivity): Intent
        {
            val imagePath = File(context.cacheDir, "images")
            val newFile = File(imagePath, "image.png")
            val contentUri: Uri =
                FileProvider.getUriForFile(context, "com.example.imoteb.fileprovider", newFile)
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION) // temp permission for receiving app to read this file
            shareIntent.setDataAndType(contentUri, activity.contentResolver?.getType(contentUri))
            shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri)
            return shareIntent
        }

        private fun SaveImageOnCatch(context: Context, bitmap: Bitmap): Boolean
        {
            try
            {
                val cachePath = File(context.cacheDir, "images")
                cachePath.mkdirs() // don't forget to make the directory
                val stream =
                    FileOutputStream("$cachePath/image.png") // overwrites this image every time
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                stream.close()
            } catch(e: IOException)
            {
                e.printStackTrace()
                return false
            }
            return true
        }
    }
}