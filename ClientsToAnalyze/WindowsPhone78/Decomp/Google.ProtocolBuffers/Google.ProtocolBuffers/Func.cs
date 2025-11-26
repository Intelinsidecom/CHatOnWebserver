namespace Google.ProtocolBuffers;

internal delegate TResult Func<TResult>();
internal delegate TResult Func<T, TResult>(T arg);
internal delegate TResult Func<T1, T2, TResult>(T1 arg1, T2 arg2);
internal delegate TResult Func<T1, T2, T3, TResult>(T1 arg1, T2 arg2, T3 arg3);
internal delegate TResult Func<T1, T2, T3, T4, TResult>(T1 arg1, T2 arg2, T3 arg3, T4 arg4);
