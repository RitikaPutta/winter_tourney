package org.firstinspires.ftc.teamcode.Real_Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.ftclib.internal.drivetrain.MecanumDrivetrain;

/**
 * Created by Michaela on 1/3/2018.
 */

//@Disabled
@TeleOp(name = "Mecanum Tele", group = "sample")

public class MecanumRobotTeleop extends OpMode {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public MecanumDrivetrain drivetrain;

    /**
     * User defined init method
     * <p>
     * This method will be called once when the INIT button is pressed.
     */
    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "lf");
        frontRight = hardwareMap.get(DcMotor.class, "rf");
        backLeft = hardwareMap.get(DcMotor.class, "ld");
        backRight = hardwareMap.get(DcMotor.class, "rd");

        drivetrain = new MecanumDrivetrain(new DcMotor[]{frontLeft, frontRight, backLeft, backRight});
    }

    /**
     * User defined loop method
     * <p>
     * This method will be called repeatedly in a loop while this op mode is running
     */
    @Override
    public void loop() {
        double course = Math.atan2(-gamepad1.right_stick_y, gamepad1.right_stick_x) - Math.PI/4;
        double velocity = Math.hypot(gamepad1.right_stick_x, gamepad1.right_stick_y);
        double rotation = -gamepad1.left_stick_x;

        drivetrain.setCourse(course);
        drivetrain.setVelocity(velocity);
        drivetrain.setRotation(rotation);

        telemetry.addData("course", course);
        telemetry.addData("velocity", velocity);
        telemetry.addData("rotation", rotation);
        telemetry.update();

    }
}

