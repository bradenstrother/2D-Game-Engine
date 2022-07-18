package components;

import editor.PropertiesWindow;
import jade.GameObject;
import jade.Prefabs;
import jade.Window;
import org.joml.Vector2f;
import org.joml.Vector4f;

public class TranslateGizmo extends Component {

	private final Vector4f xAxisColor = new Vector4f(1, 0, 0, 1);
	private final Vector4f xAxisColorHover = new Vector4f();
	private final Vector4f yAxisColor = new Vector4f(0, 1, 0, 1);
	private final Vector4f yAxisColorHover = new Vector4f();

	private final GameObject xAxisObject;
	private final GameObject yAxisObject;
	private final SpriteRenderer xAxisSprite;
	private final SpriteRenderer yAxisSprite;
	private GameObject activeGameObject = null;

	private final Vector2f xAxisOffset = new Vector2f(67, 6);
	private final Vector2f yAxisOffset = new Vector2f(23, 66);

	private final PropertiesWindow pw;

	public TranslateGizmo(Sprite arrowSprite, PropertiesWindow pw) {
		this.xAxisObject = Prefabs.generateSpriteObject(arrowSprite, 16, 48);
		this.yAxisObject = Prefabs.generateSpriteObject(arrowSprite, 16, 48);
		this.xAxisSprite = this.xAxisObject.getComponent(SpriteRenderer.class);
		this.yAxisSprite = this.yAxisObject.getComponent(SpriteRenderer.class);
		this.pw = pw;

		Window.getScene().addGameObjectToScene(xAxisObject);
		Window.getScene().addGameObjectToScene(yAxisObject);
	}

	@Override
	public void update(float dt) {
		if (this.activeGameObject != null) {
			this.xAxisObject.transform.position.set(this.activeGameObject.transform.position);
			this.yAxisObject.transform.position.set(this.activeGameObject.transform.position);
			this.xAxisObject.transform.position.add(this.xAxisOffset);
			this.yAxisObject.transform.position.add(this.yAxisOffset);
		}
		this.activeGameObject = this.pw.getActiveGameObject();
		if (this.activeGameObject != null) {
			this.setActive();
		} else {
			this.setInactive();
		}
	}

	@Override
	public void start() {
		this.xAxisObject.transform.rotation = 90;
		this.yAxisObject.transform.rotation = 180;
		this.xAxisObject.setNoSerialize();
		this.yAxisObject.setNoSerialize();
	}

	private void setActive() {
		this.xAxisSprite.setColor(xAxisColor);
		this.yAxisSprite.setColor(yAxisColor);
	}

	private void setInactive() {
		this.activeGameObject = null;
		this.xAxisSprite.setColor(new Vector4f(0,0,0,0));
		this.yAxisSprite.setColor(new Vector4f(0,0,0,0));
	}
}
