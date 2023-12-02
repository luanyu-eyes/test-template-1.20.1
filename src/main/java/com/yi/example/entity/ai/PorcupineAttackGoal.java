package com.yi.example.entity.ai;

import com.yi.example.entity.custom.PorcupineEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

import java.sql.Driver;

public class PorcupineAttackGoal extends MeleeAttackGoal {
    private final PorcupineEntity entity;
    private int attackDelay = 20;
    private int ticksUnitNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;
    public PorcupineAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((PorcupineEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUnitNextAttack = 20;
    }

    @Override
    protected void attack(LivingEntity pEnemy) {
        if(isEnemyWithinAttackDistance(pEnemy)){
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }

            if(isTimeToAttack()){
                this.mob.getLookControl().lookAt(pEnemy.getX(),pEnemy.getY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        }else{
            resetAttackCoolDown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeOut = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy){
        return this.entity.distanceTo(pEnemy) <= 2f;
    }
    protected void resetAttackCoolDown(){
        this.ticksUnitNextAttack = this.getTickCount(attackDelay * 2);
    }
    protected boolean isTimeToStartAttackAnimation(){
        return this.ticksUnitNextAttack <= attackDelay;
    }
    protected  boolean isTimeToAttack(){
        return this.ticksUnitNextAttack <= 0;
    }
    protected void performAttack(LivingEntity pEnemy){
        this.resetAttackCoolDown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }
    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack){
            this.ticksUnitNextAttack = Math.max(this.ticksUnitNextAttack - 1,0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
