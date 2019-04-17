package ie.redstudio.dzoneapplicationone.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Łukasz on 18/01/2019.
 */
@Entity
data class Movie (

    @PrimaryKey(autoGenerate = true) var id: Int? = null,

    @ColumnInfo var name: String = ""

)