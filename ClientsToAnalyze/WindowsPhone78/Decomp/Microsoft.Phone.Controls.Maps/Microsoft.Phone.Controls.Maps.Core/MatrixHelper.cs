using System;
using System.Windows;
using System.Windows.Media;

namespace Microsoft.Phone.Controls.Maps.Core;

public static class MatrixHelper
{
	public static void Rotate(ref Matrix matrix, double angle)
	{
		Matrix matrix2 = CreateRotationMatrix(angle, 0.0, 0.0);
		matrix = Multiply(ref matrix, ref matrix2);
	}

	public static void RotateAt(ref Matrix matrix, double angle, Point center)
	{
		Matrix matrix2 = CreateRotationMatrix(angle, center.X, center.Y);
		matrix = Multiply(ref matrix, ref matrix2);
	}

	public static void Translate(ref Matrix matrix, double translateX, double translateY)
	{
		matrix.OffsetX += translateX;
		matrix.OffsetY += translateY;
	}

	private static Matrix Multiply(ref Matrix matrix1, ref Matrix matrix2)
	{
		return new Matrix(matrix1.M11 * matrix2.M11 + matrix1.M12 * matrix2.M21, matrix1.M11 * matrix2.M12 + matrix1.M12 * matrix2.M22, matrix1.M21 * matrix2.M11 + matrix1.M22 * matrix2.M21, matrix1.M21 * matrix2.M12 + matrix1.M22 * matrix2.M22, matrix1.OffsetX * matrix2.M11 + matrix1.OffsetY * matrix2.M21 + matrix2.OffsetX, matrix1.OffsetX * matrix2.M12 + matrix1.OffsetY * matrix2.M22 + matrix2.OffsetY);
	}

	private static Matrix CreateRotationMatrix(double degrees, double centerX, double centerY)
	{
		double num = degrees * Math.PI / 180.0;
		double num2 = Math.Sin(num);
		double num3 = Math.Cos(num);
		double offsetX = centerX * (1.0 - num3) + centerY * num2;
		double offsetY = centerY * (1.0 - num3) - centerX * num2;
		return new Matrix(num3, num2, 0.0 - num2, num3, offsetX, offsetY);
	}
}
