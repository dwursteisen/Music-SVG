/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sourceforge.musicsvg.model;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Dav
 */
@Entity
public class Song implements PersistantObject, Serializable {

    @Id @GeneratedValue
    private Integer id;
    private String title;
    private String subTitle;
    private String artist;
    private String album;
    private byte[] digest;

    @Transient
    private List<Track> tracks;
    
    private File file;
    private TablatureType tablatureType;
    
    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public File getFile() {
       return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public byte[] getDigest() {
        return digest;
    }

    public void setDigest(byte[] digest) {
        this.digest = digest;
    }

    public TablatureType getTablatureType() {
        return tablatureType;
    }

    public void setTablatureType(TablatureType tablatureType) {
        this.tablatureType = tablatureType;
    }

    
}
