package io.github.some_example_name;//package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;

public class CollisionHandler implements ContactListener { ;
    private Integer score;
    World world ;

    public CollisionHandler(World world) {
        score = 0;
        this.world = world ;
    }

    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();


        if (fixtureA == null || fixtureB == null) return;

        if((fixtureA.getUserData() instanceof redbird ||fixtureA.getUserData() instanceof yellowbird  || fixtureA.getUserData() instanceof blackbird) && (fixtureB.getUserData() instanceof pig )){
            score+=50;
            System.out.println(score);
        }
        if((fixtureB.getUserData() instanceof redbird ||fixtureB.getUserData() instanceof yellowbird  || fixtureB.getUserData() instanceof blackbird) && (fixtureA.getUserData() instanceof pig )){
            score+=50;
            System.out.println(score);
        }

//        Body bodyA = fixtureA.getBody();
//        Body bodyB = fixtureB.getBody();
//
//        if ((isBird(bodyA) && (isPig(bodyB) || isWood(bodyB))) ||
//            (isBird(bodyB) && (isPig(bodyA) || isWood(bodyA)))) {
//
//            Body targetBody ;
//
//            if (isBird(bodyA)) {
//                targetBody = bodyB;
//            } else {
//
//                targetBody = bodyA;
//            }
//
//
//            if (targetBody.getUserData() instanceof wood)  {
//                //world.destroyBody(targetBody);
//                score=score+100;
//                System.out.println(score);
                  //Gdx.app.log(score.toString(),"detected");
//
//            } else if (targetBody.getUserData() instanceof pig) {
//               // world.destroyBody(targetBody);
//                score=score+100 ;
//                System.out.println(score);
//            }
//        }
    }

    @Override
    public void endContact(Contact contact) {}

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {}

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {}

    private boolean isBird(Body body) {

        if(body.getUserData()=="bird"){
            return true;
        }
        else{
            return  false ;
        }

    }

    private boolean isPig(Body body){

        if(body.getUserData()=="pig"){
            return true;
        }
        else{
            return  false ;
        }

    }

    private boolean isWood(Body body) {
        if(body.getUserData()=="wood"){
            return true;
        }
        else{
            return  false ;
        }
    }

}
