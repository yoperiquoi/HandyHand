package Core.Gesture.Matrix.Structure;

import com.leapmotion.leap.Bone;
import com.leapmotion.leap.Finger;

import javax.management.BadAttributeValueExpException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The class of the structure of a Finger, to save positions of this one
 */
public class FingerStructure implements Serializable {
    /**
     * The structure for the bone distal
     */
    private BoneStructure distal;
    /**
     * The structure for the bone intermediate
     */
    private BoneStructure intermediate;
    /**
     * The structure for the bone proximal
     */
    private BoneStructure proximal;
    /**
     * The structure for the bone metacarpals
     */
    private BoneStructure metacarpals;
    /**
     * The type the finger
     */
    private Finger.Type type;

    /**
     * A constructor of the class FingerStructure
     * @param finger The finger that we want save information of
     * @throws BadAttributeValueExpException If the finger is null or not valid
     */
    public FingerStructure(Finger finger) throws BadAttributeValueExpException {
        if(finger == null || !finger.isValid()) throw new BadAttributeValueExpException("Finger as to be not null and valid");

        setType(finger.type());
        setDistal(new BoneStructure(finger.bone(Bone.Type.TYPE_DISTAL)));
        setIntermediate(new BoneStructure(finger.bone(Bone.Type.TYPE_INTERMEDIATE)));
        setProximal(new BoneStructure(finger.bone(Bone.Type.TYPE_PROXIMAL)));
        setMetacarpals(new BoneStructure(finger.bone(Bone.Type.TYPE_METACARPAL)));
    }

    /**
     * A constructor of the class FingerStructure
     * @param type The type of the finger
     * @param distal The structure of the bone distal
     * @param intermediate The structure of the bone intermediate
     * @param proximal The structure of the bone proximal
     * @param metacarpals The structure of the bone metacarpals
     * @throws BadAttributeValueExpException If values are null or not of the good type
     */
    public FingerStructure(Finger.Type type, BoneStructure distal, BoneStructure intermediate, BoneStructure proximal, BoneStructure metacarpals) throws BadAttributeValueExpException {
        setType(type);
        setDistal(distal);
        setIntermediate(intermediate);
        setProximal(proximal);
        setMetacarpals(metacarpals);
    }

    /**
     * A method to get all the bones structure of this hand structure
     * @return All the bones structure of this hand structure
     */
    public List<BoneStructure> getBonesStructure() {
        List<BoneStructure> lb = new ArrayList<>();

        lb.add(getDistal());
        lb.add(getIntermediate());
        lb.add(getProximal());
        lb.add(getMetacarpals());

        return lb;
    }

    /**
     * The getter of the type of the finger
     * @return The type of the finger
     */
    public Finger.Type getType() {
        return type;
    }

    /**
     * The getter of the bone distal of the finger
     * @return The BoneStructure of bone distal of the finger
     */
    public BoneStructure getDistal() {
        return distal;
    }

    /**
     * The getter of the bone intermediate of the finger
     * @return The BoneStructure of bone intermediate of the finger
     */
    public BoneStructure getIntermediate() {
        return intermediate;
    }

    /**
     * The getter of the bone proximal of the finger
     * @return The BoneStructure of bone proximal of the finger
     */
    public BoneStructure getProximal() {
        return proximal;
    }

    /**
     * The getter of the bone metacarpals of the finger
     * @return The BoneStructure of bone metacarpals of the finger
     */
    public BoneStructure getMetacarpals() {
        return metacarpals;
    }

    /**
     * The setter of the type of the finger
     * @param type The type of the finger
     */
    private void setType(Finger.Type type) {
        this.type = type;
    }

    /**
     * The setter of the bone distal of the finger
     * @param distal The BoneStructure of bone distal of the finger
     * @throws BadAttributeValueExpException If the BoneStructure is null or not of the good type
     */
    private void setDistal(BoneStructure distal) throws BadAttributeValueExpException {
        if(distal.getType() == null) throw new BadAttributeValueExpException("The bone as to be not null");
        if(distal.getType() != Bone.Type.TYPE_DISTAL) throw new BadAttributeValueExpException("The bone as to be of type distal");
        this.distal = distal;
    }

    /**
     * The setter of the bone intermediate of the finger
     * @param intermediate The BoneStructure of bone intermediate of the finger
     * @throws BadAttributeValueExpException If the BoneStructure is null or not of the good type
     */
    private void setIntermediate(BoneStructure intermediate) throws BadAttributeValueExpException {
        if(intermediate.getType() == null) throw new BadAttributeValueExpException("The bone as to be not null");
        if(intermediate.getType() != Bone.Type.TYPE_INTERMEDIATE) throw new BadAttributeValueExpException("The bone as to be of type intermediate");
        this.intermediate = intermediate;
    }

    /**
     * The setter of the bone proximal of the finger
     * @param proximal The BoneStructure of bone proximal of the finger
     * @throws BadAttributeValueExpException If the BoneStructure is null or not of the good type
     */
    private void setProximal(BoneStructure proximal) throws BadAttributeValueExpException {
        if(proximal.getType() == null) throw new BadAttributeValueExpException("The bone as to be not null");
        if(proximal.getType() != Bone.Type.TYPE_PROXIMAL) throw new BadAttributeValueExpException("The bone as to be of type proximal");
        this.proximal = proximal;
    }

    /**
     * The setter of the bone metacarpals of the finger
     * @param metacarpals The BoneStructure of bone metacarpals of the finger
     * @throws BadAttributeValueExpException If the BoneStructure is null or not of the good type
     */
    private void setMetacarpals(BoneStructure metacarpals) throws BadAttributeValueExpException {
        if(metacarpals.getType() == null) throw new BadAttributeValueExpException("The bone as to be not null");
        if(metacarpals.getType() != Bone.Type.TYPE_METACARPAL) throw new BadAttributeValueExpException("The bone as to be of type metacarpals");
        this.metacarpals = metacarpals;
    }
}
