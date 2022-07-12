package components;

import org.joml.Vector2f;
import org.w3c.dom.Text;
import renderer.Texture;

public class Sprite {

    private final Texture texture;
    private final Vector2f[] texCoords;

    public Sprite(Texture texture) {
        this.texture = texture;
        Vector2f[] texCoords = {
                new Vector2f(1, 1), // Top right
                new Vector2f(1, 0), // Bottom right
                new Vector2f(0, 0), // Bottom left
                new Vector2f(0, 1)  // Top left
        };
        this.texCoords = texCoords;
    }

    public Sprite(Texture texture, Vector2f[] texCoords) {
        this.texture = texture;
        this.texCoords = texCoords;
    }

    public Texture getTexture() {
        return this.texture;
    }

    public Vector2f[] getTexCoords() {
        return this.texCoords;
    }
}
