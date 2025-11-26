namespace Microsoft.Phone.Controls.Maps.Core;

public interface IProjectable
{
	MapBase ParentMap { get; }

	void ProjectionUpdated(ProjectionUpdateLevel updateLevel);
}
