package components;

import editor.PropertiesWindow;
import jade.MouseListener;

public class ScaleGizmo extends Gizmo {

	public ScaleGizmo(Sprite scaleSprite, PropertiesWindow pw) {
		super(scaleSprite, pw);
	}

	@Override
	public void update(float dt) {
		if (activeGameObject != null) {
			if (xAxisActive && !yAxisActive) {
				activeGameObject.transform.scale.x -= MouseListener.getWorldDx();
			} else if (yAxisActive) {
				activeGameObject.transform.scale.y -= MouseListener.getWorldDy();
			}
		}

		super.update(dt);
	}
}
