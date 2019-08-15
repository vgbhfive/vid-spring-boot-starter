package cn.vgbhfive.vid.service.model;

import lombok.Data;

/**
 * @time: 2019/08/15
 * @author: Vgbh
 */
@Data
public class IDMeta {

    private byte machineBits;

    private byte seqBits;

    private byte timeBits;

    private byte genMethodBits;

    private byte typeBits;

    private byte versionBits;

    public IDMeta(byte machineBits, byte seqBits, byte timeBits, byte genMethodBits, byte typeBits, byte versionBits) {
        this.machineBits = machineBits;
        this.seqBits = seqBits;
        this.timeBits = timeBits;
        this.genMethodBits = genMethodBits;
        this.typeBits = typeBits;
        this.versionBits = versionBits;
    }

    /**
     * 获取长度
     * @return
     */
    public long getMachineBitsMask() {
        return -1L ^ -1L << machineBits;
    }

    /**
     * 获取Seq 起始位置
     * @return
     */
    public short getSeqBitsStartPos() {
        return machineBits;
    }

    /**
     * 获取长度
     * @return
     */
    public long getSeqBitsMask() {
        return -1L ^ -1L << seqBits;
    }

    /**
     * 获取起始位置
     * @return
     */
    public long getTimeBitsStartPos() {
        return machineBits + seqBits;
    }

    /**
     * 获取长度
     * @return
     */
    public long getTimeBitsMask() {
        return -1L ^ -1L << timeBits;
    }

    /**
     * 获取GenMethod 起始位置
     * @return
     */
    public long getGenMethodBitsStartPos() {
        return machineBits + seqBits + timeBits;
    }

    /**
     * 获取长度
     * @return
     */
    public long getGenMethodBitsMask() {
        return -1L ^ -1L << genMethodBits;
    }

    /**
     * 获取Type 起始位置
     * @return
     */
    public long getTypeBitsStartPos() {
        return machineBits + seqBits + timeBits + genMethodBits;
    }

    /**
     * 获取长度
     * @return
     */
    public long getTypeBitsMask() {
        return -1L ^ -1L << typeBits;
    }

    /**
     * 获取Version 起始位置
     * @return
     */
    public long getVersionBitsStartPos() {
        return machineBits + seqBits + timeBits + genMethodBits + typeBits;
    }

    /**
     * 获取长度
     * @return
     */
    public long getVersionBitsMask() {
        return -1L ^ -1L << versionBits;
    }

}
